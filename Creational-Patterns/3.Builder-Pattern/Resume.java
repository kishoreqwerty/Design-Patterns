import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resume {

    // Required fields
    private final String fullName;
    private final String email;

    // Optional fields
    private final String phone;
    private final String summary;
    private final String education;
    private final List<String> skills;
    private final List<String> projects;

    // Resume objects can only be created through the Builder
    private Resume(Builder builder) {
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.summary = builder.summary;
        this.education = builder.education;

        // Create copies to prevent modification after construction
        this.skills = Collections.unmodifiableList(
                new ArrayList<>(builder.skills)
        );

        this.projects = Collections.unmodifiableList(
                new ArrayList<>(builder.projects)
        );
    }

    // Displays the completed resume
    public void display() {
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + email);

        if (phone != null) {
            System.out.println("Phone: " + phone);
        }

        if (summary != null) {
            System.out.println("Summary: " + summary);
        }

        if (education != null) {
            System.out.println("Education: " + education);
        }

        if (!skills.isEmpty()) {
            System.out.println("Skills: " + String.join(", ", skills));
        }

        if (!projects.isEmpty()) {
            System.out.println("Projects:");

            for (String project : projects) {
                System.out.println("- " + project);
            }
        }
    }

    public static class Builder {

        // Required fields
        private final String fullName;
        private final String email;

        // Optional fields with default values
        private String phone;
        private String summary;
        private String education;
        private final List<String> skills = new ArrayList<>();
        private final List<String> projects = new ArrayList<>();

        // Required information must be provided first
        public Builder(String fullName, String email) {
            if (fullName == null || fullName.isBlank()) {
                throw new IllegalArgumentException(
                        "Full name cannot be empty"
                );
            }

            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException(
                        "Email cannot be empty"
                );
            }

            this.fullName = fullName;
            this.email = email;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withEducation(String education) {
            this.education = education;
            return this;
        }

        public Builder addSkill(String skill) {
            if (skill != null && !skill.isBlank()) {
                skills.add(skill);
            }

            return this;
        }

        public Builder addProject(String project) {
            if (project != null && !project.isBlank()) {
                projects.add(project);
            }

            return this;
        }

        // Creates the final Resume object
        public Resume build() {
            return new Resume(this);
        }
    }

    public static void main(String[] args) {

        Resume developerResume = new Resume.Builder(
                "Kishore Kumar J",
                "kishore@example.com"
        )
                .withPhone("+1 812-555-1234")
                .withSummary(
                        "Software Engineer experienced in backend systems " +
                        "and AI applications."
                )
                .withEducation(
                        "Master of Science in Data Science"
                )
                .addSkill("Java")
                .addSkill("C++")
                .addSkill("Python")
                .addSkill("Docker")
                .addProject(
                        "Multi-Agent Compliance Monitoring System"
                )
                .addProject(
                        "Distributed End-of-Day Processing Framework"
                )
                .build();

        developerResume.display();
    }
}