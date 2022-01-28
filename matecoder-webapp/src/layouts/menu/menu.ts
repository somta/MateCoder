/**
 * 该插件可根据菜单配置自动生成 ANTD menu组件
 * menuOptions示例：
 * [
 *  {
 *    name: '菜单名称',
 *    path: '菜单路由',
 *    fullPath: '菜单路由完整地址',
 *    meta: {
 *      icon: '菜单图标',
 *      invisible: 'boolean, 是否不可见, 默认 false',
 *    },
 *    children: [子菜单配置]
 *  },
 *  {
 *    name: '菜单名称',
 *    path: '菜单路由',
 *    fullPath: '菜单路由完整地址',
 *    meta: {
 *      icon: '菜单图标',
 *      invisible: 'boolean, 是否不可见, 默认 false',
 *    },
 *    children: [子菜单配置]
 *  }
 * ]
 *
 **/
import { defineComponent, h } from 'vue';
import { Menu } from 'ant-design-vue';
import Icon from './Icon.vue';
import fastEqual from 'fast-deep-equal';
import { RouterLink } from 'vue-router';
const { Item, SubMenu } = Menu;
type RouteItem = any;
type MenuItem = any;

const resolvePath = (path: string, params = {}) => {
  let _path = path;
  Object.entries(params).forEach(([key, value]: any) => {
    _path = _path.replace(new RegExp(`:${key}`, 'g'), value);
  });
  return _path;
};

/**
 * 将传入的路由信息转换成一个路由的map
 * @param routes
 * @returns {{}}
 */
const toRoutesMap = (routes: RouteItem[]) => {
  const map: Record<string, RouteItem> = {};
  routes.forEach((route) => {
    map[route.fullPath] = route;
    if (route.children && route.children.length > 0) {
      const childrenMap = toRoutesMap(route.children);
      Object.assign(map, childrenMap);
    }
  });
  return map;
};

export default defineComponent({
  name: 'IMenu',
  props: {
    options: {
      type: Array,
      required: true,
    },
    theme: {
      type: String,
      required: false,
      default: 'dark',
    },
    mode: {
      type: String,
      required: false,
      default: 'inline',
    },
    collapsed: {
      type: Boolean,
      required: false,
      default: false,
    },
    openKeys: Array,
  },
  data(): {
    selectedKeys: string[];
    sOpenKeys: string[];
    cachedOpenKeys: string[];
  } {
    return {
      selectedKeys: [],
      sOpenKeys: [],
      cachedOpenKeys: [],
    };
  },
  computed: {
    menuTheme() {
      return this.theme == 'light' ? this.theme : 'dark';
    },
    routesMap() {
      return toRoutesMap(this.options);
    },
  },
  created() {
    this.updateMenu();
    const options: any = this.options;
    if (options.length > 0 && !options[0].fullPath) {
      this.formatOptions(options, '');
    }
  },
  watch: {
    options(val) {
      if (val.length > 0 && !val[0].fullPath) {
        this.formatOptions(this.options, '');
      }
    },
    collapsed(val) {
      if (val) {
        this.cachedOpenKeys = this.sOpenKeys;
        this.sOpenKeys = [];
      } else {
        this.sOpenKeys = this.cachedOpenKeys;
      }
    },
    $route: function () {
      this.updateMenu();
    },
    sOpenKeys(val) {
      this.$emit('openChange', val);
      this.$emit('update:openKeys', val);
    },
  },
  methods: {
    /**
     * 渲染图标
     * @param icon
     * @param key
     * @returns {null|*|VNode[]}
     */
    renderIcon: function (icon: string, key: string) {
      if (this.$slots.icon && icon && icon !== 'none') {
        const vnodes: any = this.$slots.icon({ icon, key });
        vnodes.forEach((vnode: any) => {
          vnode.data.class = vnode.data.class ? vnode.data.class : [];
          vnode.data.class.push('anticon');
        });
        return vnodes;
      }
      return !icon || icon == 'none' ? null : h(Icon, { value: icon });
    },
    /**
     * 渲染子菜单
     * @param menu
     * @returns {*}
     */
    renderMenuItem: function (menu: MenuItem) {
      let tag: any = RouterLink;
      const path = resolvePath(menu.fullPath, menu.meta.params);
      let config: any = {
        to: { path, query: menu.meta.query },
        style: 'overflow:hidden;white-space:normal;text-overflow:clip;',
      };
      if (menu.meta && menu.meta.link) {
        tag = 'a';
        config = {
          style: 'overflow:hidden;white-space:normal;text-overflow:clip;',
          href: menu.meta.link,
          target: '_blank',
        };
      }
      return h(
        Item,
        { key: menu.fullPath },
        {
          default: () => [
            h(tag, config, {
              default: () => [this.renderIcon(menu.meta ? menu.meta.icon : 'none', menu.fullPath), menu.name],
            }),
          ],
        }
      );
    },
    /**
     * 渲染子菜单
     * @param h
     * @param menu
     * @returns {*}
     */
    renderSubMenu: function (menu: MenuItem) {
      // eslint-disable-next-line @typescript-eslint/no-this-alias
      const this_ = this;
      const subItem = [
        h(
          'span',
          { style: 'overflow:hidden;white-space:normal;text-overflow:clip;' },
          { default: () => [this.renderIcon(menu.meta ? menu.meta.icon : 'none', menu.fullPath), menu.name] }
        ),
      ];
      const itemArr: any[] = [];
      menu.children.forEach(function (item: MenuItem) {
        itemArr.push(this_.renderItem(item));
      });
      return h(
        SubMenu,
        { key: menu.fullPath },
        {
          default: () => itemArr,
          title: () => subItem,
        }
      );
    },
    /**
     * 渲染菜单的单个item
     * @param h
     * @param menu
     * @returns {*}
     */
    renderItem: function (menu: MenuItem) {
      const meta = menu.meta;
      if (!meta || !meta.invisible) {
        let renderChildren = false;
        const children = menu.children;
        if (children != undefined) {
          for (let i = 0; i < children.length; i++) {
            const childMeta = children[i].meta;
            if (!childMeta || !childMeta.invisible) {
              renderChildren = true;
              break;
            }
          }
        }
        return menu.children && renderChildren ? this.renderSubMenu(menu) : this.renderMenuItem(menu);
      }
    },
    /**
     * 渲染菜单主方法
     * @param h
     * @param menuTree
     * @returns {[]}
     */
    renderMenu: function (menuTree: MenuItem[]) {
      // eslint-disable-next-line @typescript-eslint/no-this-alias
      const this_ = this;
      const menuArr: MenuItem[] = [];
      menuTree.forEach(function (menu) {
        menuArr.push(this_.renderItem(menu));
      });
      return menuArr;
    },

    formatOptions(options: RouteItem[], parentPath: string) {
      options.forEach((route) => {
        const isFullPath = route.path.substring(0, 1) == '/';
        route.fullPath = isFullPath ? route.path : parentPath + '/' + route.path;
        if (route.children) {
          this.formatOptions(route.children, route.fullPath);
        }
      });
    },
    /**
     *
     */
    updateMenu() {
      this.selectedKeys = this.getSelectedKeys();
      let openKeys = this.selectedKeys.filter((item) => item !== '');
      openKeys = openKeys.slice(0, openKeys.length - 1);
      if (!fastEqual(openKeys, this.sOpenKeys)) {
        this.collapsed || this.mode === 'horizontal' ? (this.cachedOpenKeys = openKeys) : (this.sOpenKeys = openKeys);
      }
    },
    getSelectedKeys() {
      let matches = this.$route.matched;
      const route = matches[matches.length - 1];
      let chose = this.routesMap[route.path];
      if (chose?.meta && chose?.meta.highlight) {
        chose = this.routesMap[chose.meta.highlight];
        const resolve = this.$router.resolve({ path: chose.fullPath });
        matches = resolve.matched || matches;
      }
      return matches.map((item) => item.path);
    },
  },
  render() {
    const params: any = {
      theme: this.menuTheme,
      mode: this.mode,
      selectedKeys: this.selectedKeys,
      openKeys: this.openKeys ? this.openKeys : this.sOpenKeys,
      'onUpdate:openKeys': (val: any) => {
        this.sOpenKeys = val;
      },
      onClick: (obj: any) => {
        obj.selectedKeys = [obj.key];
        this.$emit('select', obj);
      },
    };
    return h(Menu, params, { default: () => this.renderMenu(this.options) });
  },
});
