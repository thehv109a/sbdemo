var app = new Vue({
	router,
	el: '#vue_main',
	data: {
		isEdit: false,
		matHang: {
			id: 0,
			ma: 'MH_',
			ten: null,
			donViTinh: null
		}
	},

	mounted() {
		this.ma = this.$route.query.ma;
		this.getData(this.ma);
	},

	methods: {
		getData(ma) {
			$.LoadingOverlay("show");
			if (ma != null) {
				this.isEdit = true;
				axios.post("api/getMatHang?ma=" + ma).then(response => {
					this.matHang = response.data;
					if (typeof (this.matHang) !== "object") {
						window.location.href = "/mathang"
					}
				}).finally(() => { });
			} else {
				this.isEdit = false;
			}
			$.LoadingOverlay("hide");
		},

		saveItem() {
			$.LoadingOverlay("show");
			axios.post("api/saveMatHang", this.matHang).then(response => {
				if (response.data === "ERROR") {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				} else if (response.data === "INVALID") {
					alert("Mã mặt hàng ko được bỏ trống, ko được chứa ký tự trắng, độ lớn < 20 và phải chưa tồn tại trong hệ thống");
				} else {
					window.location.href = "/mathangct?ma=" + response.data;
				}
			}).finally(() => { $.LoadingOverlay("hide"); });
		},

		goBack() { window.location.href = "/mathang" }
	}
});