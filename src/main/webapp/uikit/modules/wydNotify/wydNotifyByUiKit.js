appServices.factory('wydNotifyService', function($log, $timeout) {

	return {
		native : UIkit,

		addInfo : function(message, clear) {
			UIkit.notify({
				message : message,
				status : 'info',
				timeout : 5000,
				pos : 'top-center'
			});
		},

		addSuccess : function(message, clear) {
			UIkit.notify({
				message : message,
				status : 'success',
				timeout : 4000,
				pos : 'top-center'
			});
		},

		addWarning : function(message, clear) {
			UIkit.notify({
				message : message,
				status : 'warning',
				timeout : 3000,
				pos : 'top-center'
			});
		},

		addError : function(message, clear) {
			UIkit.notify({
				message : message,
				status : 'danger',
				timeout : 5000,
				pos : 'top-center'
			});
		},

		remove : function(alert) {
		},

		removeAll : function() {
		},
	};
});