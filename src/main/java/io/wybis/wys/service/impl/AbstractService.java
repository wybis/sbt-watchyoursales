package io.wybis.wys.service.impl;

import io.wybis.wys.service.AutoNumberService;

import java.text.DecimalFormat;

import javax.annotation.Resource;

public abstract class AbstractService {

	@Resource(name = "rateFormatterAndParser")
	protected DecimalFormat rateFormatter;

	@Resource(name = "amountFormatterAndParser")
	protected DecimalFormat amountFormatter;

	@Resource
	protected AutoNumberService autoNumberService;

}
