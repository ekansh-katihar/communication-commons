package com.registration.repository;

import java.util.Optional;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.registration.entity.UserInfo;
import com.registration.entity.UserNumber;


public class UserInfoRepositoryImpl {
	private DynamoDBMapper dynamoDBMapper;
	private static UserInfoRepositoryImpl INSTANCE ;
	private UserInfoRepositoryImpl() throws Exception {
		dynamoDBMapper = dynamoDBMapper();
	}
	public static UserInfoRepositoryImpl getInstance() {
		if( INSTANCE == null) {
			synchronized (UserInfoRepositoryImpl.class) {
				if( INSTANCE == null) {
					try {
						INSTANCE = new UserInfoRepositoryImpl();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return INSTANCE;
	}
	public DynamoDBMapper dynamoDBMapper() throws Exception {
		String awsRegion = "us-east-2";
		String dynamodbEndpoint = "https://dynamodb.us-east-2.amazonaws.com";
		String dynamodbAccessKey = System.getenv("DYNAMO_ACCESS_KEY");
		String dynamodbSecretKey = System.getenv("DYNAMO_SECRET_KEY");
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint, awsRegion))
				.withCredentials(
						new AWSStaticCredentialsProvider(new BasicAWSCredentials(dynamodbAccessKey, dynamodbSecretKey)))
				.build();
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		return dynamoDBMapper;
	}
	
	public UserInfo saveUserInfo(UserInfo userInfo) {
		dynamoDBMapper.save(userInfo);
		return userInfo;
	}

	public UserNumber saveUserNumber(UserNumber userNumber) {
		dynamoDBMapper.save(userNumber);
		return userNumber;
	}
	
	public Optional<UserInfo> findByPrincipal(String principal) {
		UserInfo userInfo = dynamoDBMapper.load(UserInfo.class, principal);
		Optional<UserInfo> optionalUserInfo = Optional.ofNullable(userInfo);
		return optionalUserInfo;
	}
	public Optional<UserNumber> findByPhoneNumber(String phoneNumber) {
		UserNumber userNumber = dynamoDBMapper.load(UserNumber.class, phoneNumber);
		Optional<UserNumber> optionalUserNumber = Optional.ofNullable(userNumber);
		return optionalUserNumber;
	}
	public Optional<UserNumber> findUserNumberByEmail(String phoneNumber) {
		UserNumber userNumber = dynamoDBMapper.load(UserNumber.class, phoneNumber);
		Optional<UserNumber> optionalUserNumber = Optional.ofNullable(userNumber);
		return optionalUserNumber;
	}
	 
	public String deleteUserInfo(String principal) {
		dynamoDBMapper.delete(dynamoDBMapper.load(UserInfo.class, principal));
		return "principal  : " + principal + " Deleted!";
	}
	public String deleteUserNumber(String userNumber) {
		dynamoDBMapper.delete(dynamoDBMapper.load(UserNumber.class, userNumber));
		return "principal  : " + userNumber + " Deleted!";
	}

	public String updateUserInfo(String shortUrl, UserInfo newObject) {
		return "";
	}
}
