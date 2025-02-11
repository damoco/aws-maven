/*
 * Copyright 2010-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.build.aws.maven;

enum Region {
    US("US", "s3.amazonaws.com"), //
    US_WEST_OREGON("us-west-2", "s3-us-west-2.amazonaws.com"), //
    US_WEST_NORTHERN_CALIFORNIA("us-west-1", "s3-us-west-1.amazonaws.com"), //
    EU("EU", "s3-eu-west-1.amazonaws.com"), //
    EU_IRELAND("eu-west-1", "s3-eu-west-1.amazonaws.com"), //
    GOV_CLOUD("us-gov-west-1", "us-gov-west-1.amazonaws.com"), //
    ASIA_PACIFIC_SINGAPORE("ap-southeast-1", "s3-ap-southeast-1.amazonaws.com"), //
    ASIA_PACIFIC_SYDNEY("ap-southeast-2", "s3-ap-southeast-2.amazonaws.com"), //
    ASIA_PACIFIC_TOKYO("ap-northeast-1", "s3-ap-northeast-1.amazonaws.com"), //
    SOUTH_AMERICA_SAO_PALO("sa-east-1", "s3-sa-east-1.amazonaws.com"),
    BEI_JING("cn-north-1", "s3.cn-north-1.amazonaws.com.cn"),
    NING_XIA("cn-northwest-1", "s3.cn-northwest-1.amazonaws.com.cn");

    private final String locationConstraint;

    private final String endpoint;

    private Region(String locationConstraint, String endpoint) {
        this.locationConstraint = locationConstraint;
        this.endpoint = endpoint;
    }

    String getEndpoint() {
        return this.endpoint;
    }

    String getLocationConstraint() {
        return this.locationConstraint;
    }

    static Region fromLocationConstraint(String locationConstraint) {
        for (Region region : values()) {
            if (region.getLocationConstraint().equals(locationConstraint)) {
                return region;
            }
        }

        throw new IllegalArgumentException(String.format("'%s' is not a valid location constraint",
                locationConstraint));
    }

}
