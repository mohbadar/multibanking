/**
 * Multibanking REST Api
 * Use a bank code (blz) ending with X00 000 00 like 300 000 00 to run aggainst the mock backend. Find the mock backend at ${hostname}:10010
 *
 * OpenAPI spec version: 5.1.3-SNAPSHOT
 * Contact: age@adorsys.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


/**
 * It is contained in addition to the data element 'chosenScaMethod' if challenge data is needed for SCA
 */
export interface ChallengeDataTO { 
    /**
     * Additional explanation for the PSU to explain e.g. fallback mechanism for the chosen SCA method
     */
    additionalInformation?: string;
    /**
     * String challenge data
     */
    data?: Array<string>;
    /**
     * PNG data (max. 512 kilobyte) to be displayed to the PSU, Base64 encoding, cp. [RFC4648]. This attribute is used only, when PHOTO_OTP or CHIP_OTP is the selected SCA method.
     */
    image?: string;
    /**
     * A link where the ASPSP will provides the challenge image
     */
    imageLink?: string;
    /**
     * The format type of the OTP to be typed in. The admitted values are \"characters\" or \"integer\"
     */
    otpFormat?: string;
    /**
     * The maximal length for the OTP to be typed in by the PSU
     */
    otpMaxLength?: number;
}
