package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.form.UpdateForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface UserRepository<T extends User> {
    /* Basic CRUD Operations */
    T create(T data);

//     int getNumberOfPages(int pageSize);

    T get(Long id);

    void update(T t,Long id);

    Boolean delete(Long id);

    //MAKE FOR LIST
    List<T> findAll();

    Collection<T> list();
    //List<T> findAllWithPagination(int page, int pageSize);





 //   Stream<PurchaseRequestEntity> findAll(io.getarrays.securecapita.purchaserequest.Page page);
    /* More Complex Operations */
    User getUserByEmail(String email);
    void sendVerificationCode(UserDTO user);
    User verifyCode(String email, String code);
    void resetPassword(String email);
    T verifyPasswordKey(String key);
    void renewPassword(String key, String password, String confirmPassword);
    T verifyAccountKey(String key);
    T updateUserDetails(UpdateForm user);
    void updatePassword(Long id, String currentPassword, String newPassword, String confirmNewPassword);
    void updateAccountSettings(Long userId, Boolean enabled, Boolean notLocked);
    User toggleMfa(String email);
    void updateImage(UserDTO user, MultipartFile image);
}