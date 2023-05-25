/** This error triggers when the class returned by
 * FindCallingClass is not one of the conditions in
 * the if statement. No user should ever trigger this
 * error.**/
class ClassNotFound extends Exception
{
    public ClassNotFound() {
    }
}