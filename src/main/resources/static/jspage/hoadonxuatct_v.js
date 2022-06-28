var app = new Vue({
	router,
	el: '#vue_main',
	data: {
		myDate: new Vue({ el: "#vue_mydate", data: { ngay: null, thang: null, nam: null } }),
		ma: null,
		hoaDon: {
			id: 0,
			ma: null,
			nguoiNhan: null,
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
				if (typeof (this.hoaDon.ngayLapHoaDon) === "string") {
					this.myDate.nam = this.hoaDon.ngayLapHoaDon.substring(0, 4);
					this.myDate.thang = this.hoaDon.ngayLapHoaDon.substring(5, 7);
					this.myDate.ngay = this.hoaDon.ngayLapHoaDon.substring(8, 10);
				} else {
					this.myDate.nam = this.myDate.thang = this.myDate.ngay = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				}
			}).finally(() => { });
		},
		goBack() { window.location.href = "/hoadonxuat" },
	}
});

var detail = new Vue({
	router,
	el: '#vue_detail',
	data: {
		ma: null,
		hoaDonCTRes: []
	},

	mounted() {
		$.LoadingOverlay("show");
		this.ma = this.$route.query.ma;
		this.getData(this.ma);
		$.LoadingOverlay("hide");
	},

	methods: {
		getData(ma) {
			axios.post("api/getHoaDonXuatCT?ma=" + ma).then(response => {
				console.log(JSON.stringify(response.data)); 
				this.hoaDonCTRes = response.data;
			}).finally(() => { });
		}
	}
});