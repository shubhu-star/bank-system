package com.bank.entity;

	import jakarta.persistence.Entity;
	import jakarta.validation.constraints.NotNull;
	import jakarta.validation.constraints.PositiveOrZero;
	import jakarta.validation.constraints.NotBlank;
	

	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "accounts")
	public class Account {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "Account number cannot be null")
		private String accountNumber;
		
		@NotBlank(message = "Account holder name cannot be null")
		private String accountHolderName;
		
		@NotBlank(message = "Account type cannot be null")
		private String accountType;
		
		@NotNull(message = "Balance cannot be null")
		@PositiveOrZero(message = "Balance cannot be negative")
		private Double balance;
		
		public Account() {
		}
		
		public Account(String accountNumber, String accountHolderName,  String accountType ,Double balance) {
			this.accountNumber = accountNumber;
			this.accountHolderName = accountHolderName;
			this.accountType = accountType;
			this.balance = balance;
		}
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		
				
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		public String getAccountHolderName() {
			return accountHolderName;
		}
		
		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}
		
		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		
		
		public Double getBalance() {
			return balance;
		}
		
		public void setBalance(Double balance) {
			this.balance = balance;
		}	
		
		public String ToString() {
			return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountHolderName="
					+ accountHolderName + ", accountType=" + accountType + ", balance=" + balance + "]";
		}

}
