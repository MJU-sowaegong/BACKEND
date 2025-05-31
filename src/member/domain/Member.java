package member.domain;

public class Member {
    private Long id;
    private String name;
    private Role role;


    // Builder
    public static class Builder {
        private Long id;
        private String name;
        private Role role;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder role(Role role) {
            this.role= role;
            return this;
        }
        public Member build() {
            return new Member(id, name, role);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Member(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() { return role; }

}
