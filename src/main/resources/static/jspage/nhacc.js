var app = new Vue({
	el: '#app',
	data: { result: [] },
	mounted() { this.getData() },
	methods: {
		getData() {
			$.LoadingOverlay("show");
			axios.get("api/getListNhacc").then(response => {
				this.result = response.data;
			}).finally(() => { $.LoadingOverlay("hide") });
		},
	}
});