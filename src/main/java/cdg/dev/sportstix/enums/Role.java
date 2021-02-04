package cdg.dev.sportstix.enums;
public enum Role {
	
    ROLE_USER(Authority.USER_AUTHORITIES),
    ROLE_ADMIN(Authority.ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(Authority.SUPER_ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
    
    private static class Authority {
    	private static final String USER_READ = "user:read";
    	protected static final String[] USER_AUTHORITIES = { USER_READ };
    	protected static final String[] ADMIN_AUTHORITIES = { USER_READ, "user:create", "user:update" };
    	protected static final String[] SUPER_ADMIN_AUTHORITIES = { USER_READ, "user:create", "user:update", "user:delete" };

    }
}
