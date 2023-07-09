package web

import arrow.core.*
import arrow.core.extensions.either.apply.tupled
import arrow.core.extensions.fx

data class PersonalName(
    val firstName: String10.T,
    val lastName: String10.T
)

data class Customer(
    val id: CustomerId.T,
    val name: PersonalName,
    val email: EmailAddress.T
)

// All possible things that can happen in the use-cases
sealed class DomainMessage {
    // Validation errors
    // Note: I deliberately choose extremely specific ones to
    // show how easy it is to have fine detail in the errors

    // 유효성 검사 오류
    // 참고: 오류의 세부 사항을 상세하게 보여주기 위해 특정한 오류를 고의로 선택했습니다.
    object CustomerIsRequired : DomainMessage()
    object CustomerIdMustBePositive : DomainMessage()
    object FirstNameIsRequired : DomainMessage()
    object FirstNameMustNotBeMoreThan10Chars : DomainMessage()
    object LastNameIsRequired : DomainMessage()
    object LastNameMustNotBeMoreThan10Chars : DomainMessage()
    object EmailIsRequired : DomainMessage()
    object EmailMustNotBeMoreThan20Chars : DomainMessage()
    object EmailMustContainAtSign : DomainMessage()

    // Events
    data class EmailAddressChanged(val oldEmail: String, val newEmail: String) : DomainMessage()

    // Exposed errors
    object CustomerNotFound : DomainMessage()

    // Internal errors
    object SqlCustomerIsInvalid : DomainMessage()
    object DatabaseTimeout : DomainMessage()
    data class DatabaseError(val message: String) : DomainMessage()
}

// ==============================
// Utility functions
// ==============================

fun createFirstName(firstName: String): Either<DomainMessage, String10.T> =
    String10.create(firstName).mapLeft { error ->
        when (error) {
            StringError.Missing -> DomainMessage.FirstNameIsRequired
            is MustNotBeLongerThan -> DomainMessage.FirstNameMustNotBeMoreThan10Chars
            is DoesntMatchPattern -> throw IllegalArgumentException("Not expecting DoesntMatchPattern for firstName")
        }
    }


fun createLastName(lastName: String): Either<DomainMessage, String10.T> =
    String10.create(lastName).mapLeft { error ->
        when (error) {
            StringError.Missing -> DomainMessage.LastNameIsRequired
            is MustNotBeLongerThan -> DomainMessage.LastNameMustNotBeMoreThan10Chars
            is DoesntMatchPattern -> throw IllegalArgumentException("Not expecting DoesntMatchPattern for lastName")
        }
    }

fun createEmail(email: String): Either<DomainMessage, EmailAddress.T> =
    EmailAddress.create(email).mapLeft { error ->
        when (error) {
            StringError.Missing -> DomainMessage.EmailIsRequired
            is MustNotBeLongerThan -> DomainMessage.EmailMustNotBeMoreThan20Chars
            is DoesntMatchPattern -> DomainMessage.EmailMustContainAtSign
        }
    }

fun createCustomerId(customerId: Int): Either<DomainMessage, CustomerId.T> =
    CustomerId.create(customerId).mapLeft { error ->
        when (error) {
            IntegerError.Missing -> DomainMessage.CustomerIsRequired
            is MustBePositiveInteger -> DomainMessage.CustomerIdMustBePositive
        }
    }

fun createPersonalName(firstName: String10.T, lastName: String10.T): PersonalName =
    PersonalName(firstName, lastName)

fun createCustomer(
    custId: CustomerId.T,
    name: PersonalName,
    email: EmailAddress.T
): Customer =
    Customer(custId, name, email)
