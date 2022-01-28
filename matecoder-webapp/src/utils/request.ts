/**
 * request 网络请求工具
 * 更详细的 api 文档: https://github.com/umijs/umi-request
 */
import { notification } from 'ant-design-vue';
import { extend } from 'umi-request';
import { getToken } from '@/utils/token';
//import { getToken } from './token';
notification.config({
  placement: 'topRight',
  top: '50px',
  duration: 5,
});
//const baseUrl = process.env.NODE_ENV === 'production' ? '' : '';

interface IHttpCodeMessage {
  [key: number]: string;
}
const httpCodeMessage: IHttpCodeMessage = {
  200: '服务器成功返回请求的数据。',
  201: '新建或修改数据成功。',
  202: '一个请求已经进入后台排队（异步任务）。',
  204: '删除数据成功。',
  400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
  401: '用户没有权限（令牌、用户名、密码错误）。',
  403: '用户得到授权，但是访问是被禁止的。',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
  406: '请求的格式不可得。',
  410: '请求的资源被永久删除，且不会再得到的。',
  422: '当创建一个对象时，发生一个验证错误。',
  500: '服务器发生错误，请检查服务器。',
  502: '网关错误。',
  503: '服务不可用，服务器暂时过载或维护。',
  504: '网关超时。',
};

interface IErrorCodeMessage {
  [key: string]: string;
}
const errorCodeMessage: IErrorCodeMessage = {
  'system.error': '系统错误',
  'returnType.error': '返回类型错误',
  'returnNull.error': '返回结果为空',
  'unknown.error': '未知错误',
};

/**
 * 配置request请求时的默认参数
 */
const request = extend({
  //prefix: baseUrl,
  // errorHandler, // 默认错误处理
  credentials: 'include', // 默认请求是否带上cookie
  timeout: 480000,
  requestType: 'json',
});

/**
 * 自定义请求头处理
 */
let customHeaders = {};
const token = getToken('Authorization');
if (token) {
  console.log('set');
  customHeaders = { Authorization: token };
}

request.interceptors.request.use((url, options) => {
  const { headers, ...restOptions } = options;
  return {
    url,
    options: {
      ...restOptions,
      headers: {
        ...headers,
        ...customHeaders,
      },
    },
  };
});

/**
 * 提前对响应做异常处理
 */
request.interceptors.response.use((response) => {
  console.log('第一个响应处理', response);
  const rawHttpCodeErrorText = httpCodeMessage[response.status] || response.statusText;
  const { status } = response;
  if (status >= 400 && rawHttpCodeErrorText) {
    notification.error({
      message: `请求错误`,
      description: rawHttpCodeErrorText,
    });
    throw new Error(rawHttpCodeErrorText);
  }
  return response;
});

/**
 * 克隆响应对象做解析处理
 */
request.interceptors.response.use(async (response) => {
  console.log('第二个响应处理', response);
  const data = await response.clone().json();
  if (response.status === 200 && data.errorCode) {
    notification.error({
      description: data.errorMessage ? data.errorMessage : '',
      message: errorCodeMessage[data.errorCode] ? errorCodeMessage[data.errorCode] : data.errorMessage,
    });
    throw new Error(data.errorCode);
  }
  return response;
});

export default request;
