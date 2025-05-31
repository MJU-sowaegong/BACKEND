package career.service;

import member.domain.Role;

import java.util.Objects;

public class RolePair {
    private final Role memberRole;
    private final Role professorRole;

    public RolePair(Role memberRole, Role professorRole) {
        this.memberRole = memberRole;
        this.professorRole = professorRole;
    }

    public Role getMemberRole() {
        return memberRole;
    }

    public Role getProfessorRole() {
        return professorRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePair)) return false;
        RolePair rolePair = (RolePair) o;
        return memberRole == rolePair.memberRole &&
                professorRole == rolePair.professorRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberRole, professorRole);
    }


}
