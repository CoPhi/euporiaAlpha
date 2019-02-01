package euporia.database.usermanagement;

/**
 * This represents the possible roles that can be assigned to groups.
 * Here's an explanation of the meaning of these roles:
 * <ul>
 *     <li>Admin: as it may be obvious, this group has basically all the possible privileges;</li>
 *     <li>Manager: this group can manage users and their projects, on which it has full permissions;</li>
 *     <li>Teacher: this group can manage other users and their projects, as long as they belong in a group with
 *     role STUDENT;</li>
 *     <li>Student: this group has basically same permissions of the SIMPLE group. Only difference is they can be
 *     managed by the TEACHER group;</li>
 *     <li>Simple: this group has basic permissions, it can create new projects and manage them.</li>
 * </ul>
 */
public enum GroupRoles {
    ADMIN,
    MANAGER,
    TEACHER,
    STUDENT,
    SIMPLE
}
