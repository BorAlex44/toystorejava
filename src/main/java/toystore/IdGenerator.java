package toystore;

import java.util.UUID;
public class IdGenerator {
            public static UUID createId(){
                UUID id = UUID.randomUUID();
                return id;

            }
}
