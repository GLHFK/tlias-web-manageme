package com.example.tliaswebmanageme.Utils;

import java.io.*;
import java.util.UUID;

import com.aliyun.oss.*;

import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.example.tliaswebmanageme.pojo.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class OssJavaSdkQuickStart {
    @Autowired
    private Point point;
    private String endpoint;
    private String bucketName;
    private String region;

    public String upload(byte[] bytes, String filename) throws com.aliyuncs.exceptions.ClientException {
        endpoint = point.getEndpoint();
        bucketName = point.getBucketName();
        region = point.getRegion();
        EnvironmentVariableCredentialsProvider credentialsProvider =
                CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .region(region)
                .build();
        try {
            String newFilename = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            ossClient.putObject(bucketName, newFilename, new ByteArrayInputStream(bytes));
            System.out.println("文件 " + newFilename + " 上传成功。");
            //列出文件
            System.out.println("列出 Bucket 中的文件：");
            ObjectListing objectListing = ossClient.listObjects(bucketName);
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + " (大小 = " + objectSummary.getSize() + ")");
            }
            return "https://" + bucketName + "." + endpoint.substring(endpoint.indexOf("//") + 2) + "/" + newFilename;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return "wrong";
    }
}