package com.patrickanker.isay.formatters;

import com.patrickanker.isay.ISMain;
import com.patrickanker.isay.lib.util.Formatter;

public class ConsoleMessageFormatter extends Formatter {

    @Override
    public String formatMessage(String in, Object... otherArgs)
    {
        String master = ISMain.getInstance().getConfigData().getString("console-format");

        if (master == null) {
            master = ISMain.getDefaultConsoleFormat();
            ISMain.getInstance().getConfigData().setString("console-format", ISMain.getDefaultConsoleFormat());
        }

        master = Formatter.encodeColors(master);
        master = master.replace("$message", in);
        master = master.replace("$m", in);

        return master;
    }

    @Override
    public String[] formatMessages(String in, Object... otherArgs)
    {
        return new String[]{formatMessage(in, otherArgs)};
    }
}