export * from './token';
export * from './validate';

export function getValidLocalStorageItem(key: string, callback: any, rawData = true) {
  if (window.localStorage && localStorage.getItem(key)) {
    let item: string | null = localStorage.getItem(key);
    if (rawData) {
      if (typeof callback === 'function') {
        callback(item);
      }
    } else {
      if (typeof callback === 'function') {
        let parseValue = JSON.parse(typeof item === 'string' ? item : '');
        callback(parseValue);
      }
    }
    return true;
  } else {
    return false;
  }
}
