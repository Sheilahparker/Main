package com.tts.eCommerce.model;

import java.util.Collection;
import java.util.Map;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@SuppressWarnings("serial")

public class User implements UserDetails {

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 @NotEmpty(message = "Please provide a username")
	    @Length(min = 3, message = "Your username must have at least 3 characters")
	    @Length(max = 15, message = "Your username cannot have more than 15 characters")
	    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
	    private String username;
	 
	 @Length(min = 5, message = "Your password must have at least 5 characters")
	    @NotEmpty(message = "Please provide a password")
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;

	 @ElementCollection
		private Map<Product, Integer> cart;

	// UserDetails requires these, they are technically getters (is-ers?) overridden by Lombok.
	  // @Transient Makes it so these aren't persisted in the database, as they are hard coded.
	  @Transient
	  private boolean accountNonExpired = true;
	  @Transient
	  private boolean accountNonLocked = true;
	  @Transient
	  private boolean credentialsNonExpired = true;
	  @Transient
	  private boolean enabled = true;
	  @Transient
	  private Collection<GrantedAuthority> authorities = null;
	  
	  @Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public boolean isAccountNonExpired() {
			return accountNonExpired;
		}

		@Override
		public boolean isAccountNonLocked() {
			return accountNonLocked;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return credentialsNonExpired;
		}

		@Override
		public boolean isEnabled() {
			return enabled;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Map<Product, Integer> getCart() {
			return cart;
		}

		public void setCart(Map<Product, Integer> cart) {
			this.cart = cart;
		}

		public void setAccountNonExpired(boolean accountNonExpired) {
			this.accountNonExpired = accountNonExpired;
		}

		public void setAccountNonLocked(boolean accountNonLocked) {
			this.accountNonLocked = accountNonLocked;
		}

		public void setCredentialsNonExpired(boolean credentialsNonExpired) {
			this.credentialsNonExpired = credentialsNonExpired;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public void setAuthorities(Collection<GrantedAuthority> authorities) {
			this.authorities = authorities;
		}

}
