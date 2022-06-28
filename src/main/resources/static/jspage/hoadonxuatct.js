var app = new Vue({
	router,
	el: '#vue_main',
	data: {
		ma: null,
		hoaDon: {
			id: 0,
			ma: null,
			nguoiNhan: null,
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
			axios.post("api/getHoaDonXuat?ma=" + ma).then(response => {
				this.hoaDon = response.data;
				if (typeof (this.hoaDon) !== "object") {
					window.location.href = "/hoadonxuat"
				}
			}).finally(() => { });
		},

		saveItem() {
			$.LoadingOverlay("show");
			axios.post("api/updateHoaDonXuat", this.hoaDon).then(response => {
				if (response.data === "OK") {
					alert("Cập nhật hóa đơn thành công");
					window.location.href = "/hoadonxuatct?ma=" + this.ma + "&v=1";
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => {
				$.LoadingOverlay("hide");
			});
		},

		goBack() { window.location.href = "/hoadonxuat" },

		printItem() {
		}
	}
});

var detail = new Vue({
	router,
	el: '#vue_detail',
	data: {
		ma: null,
		hoaDonCTRes: [],
		hoaDonCT: {
			maHoaDonXuat: null,
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
			axios.post("api/getHoaDonXuatCT?ma=" + ma).then(response => {
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
			this.hoaDonCT.maHoaDonXuat = this.ma;
			axios.post("api/addHoaDonXuatCT", this.hoaDonCT).then(response => {
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
			axios.post("api/deleteHoaDonXuatCT?id=" + id).then(response => {
				if (response.data === "OK") {
					this.getData(this.ma);
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => { $.LoadingOverlay("hide"); });
		}
	}
});