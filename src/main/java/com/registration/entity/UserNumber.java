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
@DynamoDBTable(tableName = "user_number")
public class UserNumber  {

	private static final long serialVersionUID = 1L;


	@DynamoDBHashKey
	private String phoneNumber;
	@DynamoDBAttribute
	private String principal;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String picture;
	@DynamoDBAttribute
	private long calls;
	@DynamoDBAttribute
	private long totalCalls;
	@DynamoDBAttribute
	private Date subscriptionEndDate;
	@DynamoDBAttribute
	private Date subscriptionStartDate;
	@DynamoDBAttribute
	private String subscriptionType;
	@DynamoDBAttribute
	private String subscriptionStatus;
	@DynamoDBAttribute
	private String apiKey;
	@DynamoDBAttribute
	private Integer maxCallsPerDay;
	// TODO Timestamp or Date
    @DynamoDBAttribute
    @DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.CREATE)
	private Date createdAt;
    @DynamoDBAttribute
    @DynamoDBAutoGeneratedTimestamp(strategy=DynamoDBAutoGenerateStrategy.ALWAYS)
	private Date updatedAt;


}
