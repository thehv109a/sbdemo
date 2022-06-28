var app = new Vue({
	el: '#vue_main',
	data: {
		ma: "",
		fromDate: null,
		toDate: null,
		result: [],
		matHangs: [],
		xuatNhapTons:
			[{
				ma: null,
				ten: null,
				tonDau: null,
				tongNhap: null,
				tongXuat: null,
				tonCuoi: null
			}],
		p: null
	},
	mounted() {
		this.getListMatHangDL();
		this.getData(1);
	},
	methods: {
		getData(p) {
			this.p = p;
			$.LoadingOverlay("show");
			var params = {
				ma: this.ma,
				fromDate: this.fromDate,
				toDate: this.toDate,
				page: p,
				pageSize: 5
			}

			axios.post("api/getListXuatNhapTon", params).then(response => {
				this.result = response.data;
				this.xuatNhapTons = response.data.content;
			}).finally(() => { $.LoadingOverlay("hide"); });
		},

		getListMatHangDL() {
			axios.post("api/getListMatHangDL").then(response => {
				this.matHangs = response.data;
			}).finally(() => { });
		},

		saveItem() {
			var matHangs = []
			this.xuatNhapTons.forEach(item => {
				if (Number.isInteger(parseInt(item.tonDau))) {
					matHangs.push({ ma: item.ma, tonDau: item.tonDau });
				} else {
					matHangs.push({ ma: item.ma, soLuongTon: null });
				}
			});

			axios.post("api/saveListTonDau", matHangs).then(response => {
				if (response.data === "OK") {
					this.getData(this.p);
				} else {
					alert("Có lỗi xảy ra, vui lòng thử lại");
				}
			}).finally(() => { $.LoadingOverlay("hide"); });
		},
	}
});