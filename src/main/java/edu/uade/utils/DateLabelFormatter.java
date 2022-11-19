package edu.uade.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import edu.uade.utils.DateUtil;

public class DateLabelFormatter extends AbstractFormatter {

    @Override
    public Object stringToValue(String text) throws ParseException {
        return DateUtil.getDateFormat().parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return DateUtil.getDateFormat().format(cal.getTime());
        }
        return "";
    }

}
