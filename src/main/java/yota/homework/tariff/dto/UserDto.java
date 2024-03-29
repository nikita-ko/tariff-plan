package yota.homework.tariff.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static io.qala.datagen.RandomShortApi.Long;
import static io.qala.datagen.RandomShortApi.unicode;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public static final String PHONE_NUMBER_NOTE = "Should consist of 10 digits";
    public static final String PASSPORT_NOTE = "Should consist of 10 digits";
    public static final int NAME_LOWER_BOUNDARY = 1;
    public static final int NAME_UPPER_BOUNDARY = 60;
    public static final String NAME_NOTE = "Should be between 1 and 60 symbols";
    public static final long PASSPORT_LOWER_BOUNDARY = 1000000000L;
    public static final long PASSPORT_UPPER_BOUNDARY = 9999999999L;
    public static final long PHONE_LOWER_BOUNDARY = 9000000000L;
    public static final long PHONE_UPPER_BOUNDARY = 9999999999L;

    @NotNull(message = NAME_NOTE)
    @Size(min = NAME_LOWER_BOUNDARY, max = NAME_UPPER_BOUNDARY, message = NAME_NOTE)
    @ApiModelProperty(example = "Ivan")
    private String firstName;

    @NotNull(message = NAME_NOTE)
    @Size(min = NAME_LOWER_BOUNDARY, max = NAME_UPPER_BOUNDARY, message = NAME_NOTE)
    @ApiModelProperty(example = "Petrov")
    private String lastName;

    @NotNull(message = PASSPORT_NOTE)
    @Min(value = PASSPORT_LOWER_BOUNDARY, message = PASSPORT_NOTE)
    @Max(value = PASSPORT_UPPER_BOUNDARY, message = PASSPORT_NOTE)
    @ApiModelProperty(example = "1385698006")
    private Long passport;

    @NotNull(message = PHONE_NUMBER_NOTE)
    @Min(value = PHONE_LOWER_BOUNDARY, message = PHONE_NUMBER_NOTE)
    @Max(value = PHONE_UPPER_BOUNDARY, message = PHONE_NUMBER_NOTE)
    @ApiModelProperty(example = "9999199299")
    private Long phoneNumber;

    public static UserDto randomUserDto() {
        return UserDto.builder()
                .firstName(unicode(NAME_LOWER_BOUNDARY, NAME_UPPER_BOUNDARY))
                .lastName(unicode(NAME_LOWER_BOUNDARY, NAME_UPPER_BOUNDARY))
                .phoneNumber(Long(PHONE_LOWER_BOUNDARY, PHONE_UPPER_BOUNDARY))
                .passport(Long(PASSPORT_LOWER_BOUNDARY, PASSPORT_UPPER_BOUNDARY))
                .build();
    }
}
