package com.esiea.pootd2.commands.parsers;

import com.esiea.pootd2.commands.Command;

public interface ICommandParser {
    public Command parse(String commandStr);
}
