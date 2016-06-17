package fr.aresrpg.commons.domain.log.handler;

import java.io.IOException;
import java.io.PrintStream;

import fr.aresrpg.commons.domain.log.Log;

public class PrintStreamHandler extends BaseHandler {
	private PrintStream outStream;
	private PrintStream errorStream;

	public PrintStreamHandler(PrintStream outStream, PrintStream errorStream) {
		this.outStream = outStream;
		this.errorStream = errorStream;
	}

	public PrintStreamHandler(PrintStream stream) {
		this(stream, stream);
	}

	@Override
	public void handle(Log log) throws IOException {
		if (log.getLevel().isError()) errorStream.println(format(log));
		else outStream.println(format(log));
	}
}