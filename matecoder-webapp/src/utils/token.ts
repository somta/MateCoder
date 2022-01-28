export function setToken(key: string, vaule: string) {
  if (window.localStorage) {
    window.localStorage.setItem(key, vaule);
  }
}

export function getToken(key: string) {
  if (window.localStorage) {
    if (key) {
      return window.localStorage.getItem(key);
    } else {
      new Error('token key is null');
    }
  }
  return '';
}

export function removeToken(key: string) {
  if (window.localStorage) {
    return window.localStorage.removeItem(key);
  }
}
