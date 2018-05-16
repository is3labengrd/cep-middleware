/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.eng.cepmiddleware.api.v1;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-15T12:18:46.813Z")

@Api(value = "default", description = "the default API")
public interface DefaultApi {

    @ApiOperation(value = "Provides possible operations within the API", nickname = "rootGet", notes = "", tags={ "base", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    @RequestMapping(value = "/",
        method = RequestMethod.GET)
    ResponseEntity<?> rootGet();

}
