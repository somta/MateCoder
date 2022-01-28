import request from '@/utils/request';

export function login(username: string, password: string) {
  return request.post('/v1/login', {
    data: {
      username: username,
      password: password,
    },
  });
}
