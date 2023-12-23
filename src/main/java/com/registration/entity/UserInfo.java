package com.registration.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "user_info")
public class UserInfo  {

	private static final long serialVersionUID = 1L;

	// will get below from OAuth2User
	@DynamoDBHashKey
	private String principal;
	@DynamoDBAttribute
	private String email;
	// my custom field (name will be same as username for time being)
	@DynamoDBAttribute
	private String role;
	@DynamoDBAttribute
	private String phoneNumber;
	@DynamoDBAttribute
	private Date subscriptionStartDate;
	@DynamoDBAttribute
	private Date subscriptionEndDate;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private String picture;

	// TODO Timestamp or Date
    @DynamoDBAttribute
    @DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.CREATE)
	private Date createdAt;
    @DynamoDBAttribute
    @DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.ALWAYS)
	private Date updatedAt;

	// userDetails attributes
	@DynamoDBAttribute
	private boolean accountExpired;
	@DynamoDBAttribute
	private boolean accountLocked;
	@DynamoDBAttribute
	private boolean credentialsExpired;
	@DynamoDBAttribute
	private boolean enabled;

	 

}