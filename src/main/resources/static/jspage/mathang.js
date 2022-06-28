var app = new Vue({
	el: '#app',
	data: {
		result: [],
		ma: null,
		ten: null,
	},
	mounted() {
		this.getData(1);
	},

	methods: {
		getData(p) {
			$.LoadingOverlay("show");
			var params = {
				ma: this.ma,
				ten: this.ten,
				page: p
			}
			axios.post("api/getListMatHang", params
			).then(response => {
				this.result = response.data;
			}).finally(() => { $.LoadingOverlay("hide"); });
		},

		deleteItem(ma) {
			axios.post("api/deleteMatHang?ma=" + ma
			).then(response => {
				if (response.data === "OK") {
					window.location.href = "/mathang";
				} else if (response.data === "ERROR") {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				} else {
					alert("Không thể xóa mặt hàng vì đã có tham chiếu trong hệ thống");
				}
			}).finally(() => { });
		},

		goDetail(ma) {
			if (ma != null) {
				window.location.href = "/mathangct?ma=" + ma
			} else {
				window.location.href = "/mathangct";
			}
		},
	}
});