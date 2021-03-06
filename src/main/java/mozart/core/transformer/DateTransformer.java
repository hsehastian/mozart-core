package mozart.core.transformer;

import java.lang.reflect.Field;

import mozart.core.annotation.Date;
import mozart.core.exception.MozartException;

import org.joda.time.format.DateTimeFormat;

public class DateTransformer extends Transformer<java.util.Date> {

	@Override
	public java.util.Date transform(Field field, String value) throws MozartException {
		Date dateAnnot = field.getAnnotation(Date.class);

		String dateformat = "yyyy-MM-dd";
		if (dateAnnot != null) {
			dateformat = dateAnnot.format();
		}

		return DateTimeFormat.forPattern(dateformat).parseDateTime(value).toDate();
	}

}
