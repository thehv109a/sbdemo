var app = new Vue({
	el: '#vue_main',
	data: {
		ma: null,
		fromDate: null,
		toDate: null,
		result: [],
	},
	mounted() {
		this.getData(1);
	},
	methods: {
		getData(p) {
			$.LoadingOverlay("show");
			var params = {
				ma: this.ma,
				fromDate: this.fromDate,
				toDate: this.toDate,
				page: p
			}
			axios.post("api/getListHoaDonNhap", params).then(response => {
				this.result = response.data;
			}).finally(() => { $.LoadingOverlay("hide"); });
		},

		saveItem() {
			if (confirm("Bạn có muốn tạo hóa đơn?")) {
				axios.post("api/createHoaDonNhap").then(response => {
					if (response.data === "ERROR") {
						alert("Có lỗi, vui lòng thử lại");
					} else {
						alert("Thêm hóa đơn thành công");
						window.location.href = "/hoadonnhapct?ma=" + response.data;
					}
				}).finally(() => { });
			}
		},

		deleteItem(ma) {
			axios.post("api/deleteHoaDonNhap?ma=" + ma).then(response => {
				if (response.data === "OK") {
					window.location.href = "/hoadonnhap";
				} else if (response.data === "ERROR") {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				} else {
					alert("Không thể xóa hóa đơn vì đã có tham chiếu trong hệ thống");
				}
			}).finally(() => { });
		},

		goDetail(ma) { window.location.href = "/hoadonnhapct?ma=" + ma }
	}
});