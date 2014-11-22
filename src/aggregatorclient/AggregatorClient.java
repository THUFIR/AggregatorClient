package aggregatorclient;

import dur.ejb.AnswerSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AggregatorClient {

    private static final Logger log = Logger.getLogger(AggregatorClient.class.getName());

    public static void main(String[] args) {
        try {
            new AggregatorClient().remoteEJB();
        } catch (NamingException ex) {
            Logger.getLogger(AggregatorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void remoteEJB() throws NamingException {
        Context ctx = new InitialContext();
        log.fine(ctx.getEnvironment().toString());
        Object obj = ctx.lookup("ejb.EJBRemoteInterface");
        AnswerSessionBeanRemote asbr = (AnswerSessionBeanRemote) obj;
        log.info("answer\t" + asbr.lifeTheUniverseAndEverything());
    }

}
