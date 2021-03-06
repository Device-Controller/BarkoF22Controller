package vislab.no.ntnu.barco.communicationstates;

import vislab.no.ntnu.barco.driver.CommunicationContext;

/**
 * State representing an all ok call. The acknowledge received was ok and the command has done its work.
 */
public class AcknowledgeReceived implements CommunicationState {
    @Override
    public void execute(CommunicationContext context) {
        context.getListener().onAcknowledge(context.getAndRemove());
        context.resetSendAttempts();
        context.changeState(new Wait());
    }
}
