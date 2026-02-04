interface IdentityVerification {
    void verifyIdentity();
}

interface EnvironmentCheck {
    void checkEnvironment();
}

interface BehaviourMonitoring {
    void monitorBehaviour();
}

class AIIdentityVerification implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("AI verifying identity.");
    }
}

class HumanIdentityVerification implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Human verifying identity.");
    }
}

class BiometricIdentityVerification implements IdentityVerification {
    public void verifyIdentity() {
        System.out.println("Biometric verifying identity.");
    }
}

class AIEnvironmentCheck implements EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("AI checking environment.");
    }
}

class HumanEnvironmentCheck implements EnvironmentCheck {
    public void checkEnvironment() {
        System.out.println("Human checking environment.");
    }
}

class AIBehaviourMonitoring implements BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("AI monitoring behaviour.");
    }
}

class HumanBehaviourMonitoring implements BehaviourMonitoring {
    public void monitorBehaviour() {
        System.out.println("Human monitoring behaviour.");
    }
}

class ProctoringController {

    private IdentityVerification identity;
    private EnvironmentCheck environment;
    private BehaviourMonitoring behaviour;

    public ProctoringController(
        IdentityVerification identity,
        EnvironmentCheck environment,
        BehaviourMonitoring behaviour) {

        this.identity = identity;
        this.environment = environment;
        this.behaviour = behaviour;
    }

    public void startExam() {
        System.out.println("\n--- Proctoring Started ---");

        if (identity != null)
            identity.verifyIdentity();

        if (environment != null)
            environment.checkEnvironment();

        if (behaviour != null)
            behaviour.monitorBehaviour();

        System.out.println("--- Exam Running ---");
    }
}

public class ProctoringSystem {

    public static void main(String[] args) {

        ProctoringController exam1 =
            new ProctoringController(
                new AIIdentityVerification(),
                null,
                null
            );

        exam1.startExam();

        ProctoringController exam2 =
            new ProctoringController(
                new BiometricIdentityVerification(),
                new AIEnvironmentCheck(),
                new HumanBehaviourMonitoring()
            );

        exam2.startExam();
    }
}
