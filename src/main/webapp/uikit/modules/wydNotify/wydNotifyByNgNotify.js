appServices.factory('wydNotifyService', function($log, $timeout, ngNotify) {

	ngNotify.config({
		theme : 'pastel',
		position : 'top',
		duration : 3000,
		type : 'info',
		sticky : false
	});

	return {
		native : ngNotify,

		addInfo : function(message, clear) {
			if (clear) {
				ngNotify.dismiss();
			}
			ngNotify.set(message, {
				type : 'info',
				duration : 5000
			});
		},

		addSuccess : function(message, clear) {
			if (clear) {
				ngNotify.dismiss();
			}
			ngNotify.set(message, {
				type : 'success',
				duration : 4000
			});
		},

		addWarning : function(message, clear) {
			if (clear) {
				ngNotify.dismiss();
			}
			ngNotify.set(message, {
				type : 'warn',
				duration : 3000
			});
		},

		addError : function(message, clear) {
			if (clear) {
				ngNotify.dismiss();
			}
			ngNotify.set(message, {
				sticky : true,
				type : 'error',
				duration : 6000
			});
		},

		remove : function(alert) {
			ngNotify.dismiss();
		},

		removeAll : function() {
			ngNotify.dismiss();
		},
	};
});