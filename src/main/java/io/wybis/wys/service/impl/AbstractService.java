package io.wybis.wys.service.impl;

import java.text.DecimalFormat;

import javax.annotation.Resource;

public abstract class AbstractService {

	@Resource(name = "rateFormatterAndParser")
	protected DecimalFormat rateFormatter;

	@Resource(name = "amountFormatterAndParser")
	protected DecimalFormat amountFormatter;

}
