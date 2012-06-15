package logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * This class takes care of the HTML Log formating 
 *
 * @author Micha Schoenenberger, Andreas Gruenenfelder
 */
class MyHtmlFormatter extends Formatter
{
	/* (non-Javadoc)
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	// This method is called for every log records
	public String format(LogRecord rec)
	{
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		buf.append("<tr>");
		buf.append("<td>");

		if (rec.getLevel().intValue() >= Level.WARNING.intValue())
		{
			buf.append("<b>");
			buf.append(rec.getLevel());
			buf.append("</b>");
		} else
		{
			buf.append(rec.getLevel());
		}
		buf.append("</td>");
		buf.append("<td>");
		buf.append(calcDate(rec.getMillis()));
		buf.append(' ');
		buf.append(formatMessage(rec));
		buf.append('\n');
		buf.append("<td>");
		buf.append("</tr>\n");
		return buf.toString();
	}

	/**
	 * @param millisecs
	 * @return
	 */
	private String calcDate(long millisecs)
	{
		SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}

	/* (non-Javadoc)
	 * @see java.util.logging.Formatter#getHead(java.util.logging.Handler)
	 */
	// This method is called just after the handler using this
	// formatter is created
	public String getHead(Handler h)
	{
		return "<HTML>\n<HEAD>\n" + (new Date()) + "\n</HEAD>\n<BODY>\n<PRE>\n"
				+ "<table border>\n  "
				+ "<tr><th>Time</th><th>Log Message</th></tr>\n";
	}

	/* (non-Javadoc)
	 * @see java.util.logging.Formatter#getTail(java.util.logging.Handler)
	 */
	// This method is called just after the handler using this
	// formatter is closed
	public String getTail(Handler h)
	{
		return "</table>\n  </PRE></BODY>\n</HTML>\n";
	}
}