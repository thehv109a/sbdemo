var sbdemo_menu = new Vue({
    el: '#sbdemo_menu',
    data: {
        menus: [
            { activeClass: "", pathname: "/vms-home", name: "VMS_Trang chủ" },
            { activeClass: "", pathname: "/vms-iconnect", name: "VMS_Iconnect" },
            { activeClass: "", pathname: "/vms-naptherinhqua", name: "VMS_Nạp thẻ rinh quà" },
        ]
    },

    mounted() {
        this.menus.forEach((item, index) => {
            if (item.pathname === location.pathname) {
                item.activeClass = "active";
                this.menus[index] = item;
            }
        });
    }
});