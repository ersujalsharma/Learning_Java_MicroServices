package assignment9.sealedclasses;

public sealed class LearningSealedClasses permits SealedClass1, SealedClass2,LearningNonSealedClasses {
    // sealed classes can only be extended by classes that are permitted and final only.
}
