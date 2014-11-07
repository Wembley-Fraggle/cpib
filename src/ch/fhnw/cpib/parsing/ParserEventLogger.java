package ch.fhnw.cpib.parsing;

import org.apache.log4j.Logger;

import ch.fhnw.cpib.lexing.IToken;
import ch.fhnw.cpib.parsing.nodes.IProduction;

public class ParserEventLogger implements IParserEventListener{

    private static Logger logger = Logger.getLogger(ParserEventLogger.class);
    
    @Override
    public void onStart() {
        logger.debug("Started parsing");
    }

    @Override
    public void output(IProduction production) {
        logger.debug("Matched "+production);
    }

    @Override
    public void output(IToken token) {
        logger.debug("Matched "+token.getType().getName());
    }

    @Override
    public void onEnd() {
        logger.debug("Parsing finished");
    }

}
