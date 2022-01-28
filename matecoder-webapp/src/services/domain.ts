import request from '@/utils/request';

export function queryDomainList() {
  return request.post('/v1/domain/queryByList', {
    data: {
      pageNum: 1,
      pageSize: 10,
    },
  });
}
