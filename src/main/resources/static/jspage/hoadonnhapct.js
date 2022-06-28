var app = new Vue({
	router,
	el: '#vue_main',
	data: {
		ma: null,
		hoaDon: {
			id: 0,
			ma: null,
			nguoiGiao: null,
			diaChi: null,
			ghiChu: null,
			tongTien: null,
			ngayLapHoaDon: null,
			trangThai: null
		},
	},

	mounted() {
		$.LoadingOverlay("show");
		this.ma = this.$route.query.ma;
		this.getData(this.ma);
		$.LoadingOverlay("hide");
	},

	methods: {
		getData(ma) {
			axios.post("api/getHoaDonNhap?ma=" + ma).then(response => {
				this.hoaDon = response.data;
				if (typeof (this.hoaDon) !== "object") {
					window.location.href = "/hoadonnhap"
				}
			}).finally(() => { });
		},

		saveItem() {
			$.LoadingOverlay("show");
			axios.post("api/updateHoaDonNhap", this.hoaDon).then(response => {
				if (response.data === "OK") {
					alert("Cập nhật hóa đơn thành công");
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => {
				$.LoadingOverlay("hide");
			});
		},

		goBack() { window.location.href = "/hoadonnhap" }
	}
});

var detail = new Vue({
	router,
	el: '#vue_detail',
	data: {
		ma: null,
		hoaDonCTRes: [],
		hoaDonCT: {
			maHoaDonNhap: null,
			maMatHang: null,
			soLuong: 1,
			donGia: 0,
		},
		matHangs: []
	},

	mounted() {
		$.LoadingOverlay("show");
		this.ma = this.$route.query.ma;
		this.getData(this.ma);
		this.getListMatHangDL();
		$.LoadingOverlay("hide");
	},

	methods: {
		getData(ma) {
			axios.post("api/getHoaDonNhapCT?ma=" + ma).then(response => {
				console.log(JSON.stringify(response.data));
				this.hoaDonCTRes = response.data;
			}).finally(() => { });
		},

		getListMatHangDL() {
			axios.post("api/getListMatHangDL").then(response => {
				this.matHangs = response.data;
			}).finally(() => { });
		},

		saveItem() {
			$.LoadingOverlay("show");
			this.hoaDonCT.maHoaDonNhap = this.ma;
			axios.post("api/addHoaDonNhapCT", this.hoaDonCT).then(response => {
				if (response.data === "INVALID") {
					alert("Mặt hàng ko được bỏ trống, số lượng và đơn giá phải > 0 ");
				} else if (response.data === "OK") {
					this.getData(this.ma);
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => { $.LoadingOverlay("hide"); });
		},

		deleteItem(id) {
			$.LoadingOverlay("show");
			axios.post("api/deleteHoaDonNhapCT?id=" + id).then(response => {
				if (response.data === "OK") {
					this.getData(this.ma);
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => { $.LoadingOverlay("hide"); });
		}
	}
});