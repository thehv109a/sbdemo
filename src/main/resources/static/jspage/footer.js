function formatNumber(num) {
	if (typeof (num) === "number") {
		return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
	} else {
		return num;
	}
}

Vue.component('paginate', VuejsPaginate);
Vue.component('v-select', VueSelect.VueSelect);
var router = new VueRouter({ mode: 'history', routes: [] });
var vue_menu = new Vue({
	el: '#vue_menu',
	data: {
		activeMenu: { hoadonxuat: null, hoadonnhap: null, mathang: null, xuatnhapton: null }
	},
	mounted() {
		var url = window.location.href;
		if (url.includes("/hoadonnhap")) {
			this.activeMenu.hoadonnhap = "active";
		} else if (url.includes("/hoadonxuat")) {
			this.activeMenu.hoadonxuat = "active";
		} else if (url.includes("/mathang")) {
			this.activeMenu.mathang = "active";
		} else if (url.includes("/xuatnhapton")) {
			this.activeMenu.xuatnhapton = "active";
		}
	}
});