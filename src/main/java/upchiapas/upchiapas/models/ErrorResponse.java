package upchiapas.upchiapas.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String mensaje;
    private int codigoError;
}
