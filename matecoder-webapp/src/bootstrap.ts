import { getValidLocalStorageItem } from './utils/index';
export function Initializer() {
  getValidLocalStorageItem(
    'NormalServiceBaseInfo',
    (NormalServiceBaseInfo: any) => {
      console.log(
        '%c 🥟 NormalServiceBaseInfo: ',
        'font-size:20px;background-color: #E41A6A;color:#fff;',
        NormalServiceBaseInfo
      );
      // store.commit('webNormalTemplate/setAppBaseInfo', NormalServiceBaseInfo);
    },
    false
  );
  getValidLocalStorageItem(
    'MicroServiceBaseInfo',
    (MicroServiceBaseInfo: any) => {
      console.log(
        '%c 🍱 MicroServiceBaseInfo: ',
        'font-size:20px;background-color: #B03734;color:#fff;',
        MicroServiceBaseInfo
      );
      // store.commit('microTemplate/setAppBaseInfo', MicroServiceBaseInfo);
    },
    false
  );
}
