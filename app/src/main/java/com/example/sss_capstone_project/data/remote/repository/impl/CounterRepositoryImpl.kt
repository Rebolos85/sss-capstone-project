package com.example.sss_capstone_project.data.remote.repository.impl

import android.util.Log
import com.example.sss_capstone_project.data.remote.repository.CounterRepository
import com.example.sss_capstone_project.model.Name
import com.example.sss_capstone_project.model.response.UserResponse
import com.google.firebase.database.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(private val databaseReference: FirebaseDatabase) :
    CounterRepository() {
    private val _statePriorityNumber = MutableStateFlow<String?>("")
    private val _statePriorityCounter2 = MutableStateFlow<String?>("")
    private val _statePrioriorityCounter3 = MutableStateFlow<String?>("")
    private val _statePriorityCounter4 = MutableStateFlow<String?>("")
    private val _statePriorityTeller = MutableStateFlow<String?>("")
    private val _currentNowServingCounterA = MutableStateFlow<String?>("")
    private val _currentNowServingCounterB = MutableStateFlow<String?>("")
    private val _currentNowServingCounterC = MutableStateFlow<String?>("")
    private val _currentNowServingCounterD = MutableStateFlow<String?>("")
    private val _currentNowServingCounterE = MutableStateFlow<String?>("")
    override fun getCurrentCounterALastPriorityNumber(): Flow<String?> {

        databaseReference.reference.child("counter1")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.children.forEach { childSnapshot ->
                        val pnumber = childSnapshot.child("pnumber").getValue(String::class.java)

                        pnumber?.let {
                            _statePriorityNumber.value = it
                        } ?: run {
                            Log.d("TEST", "NULL MAN WALAAY VALUE")
                        }

                    }


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _statePriorityNumber.value = ""
                }
            })

        return _statePriorityNumber
    }

    override fun getCurrentCounterBLastPriorityNumber(): Flow<String?> {
        databaseReference.reference.child("counter2")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.children.forEach { childSnapshot ->
                        val pnumber = childSnapshot.child("pnumber").getValue(String::class.java)

                        pnumber?.let {
                            _statePriorityCounter2.value = it
                        } ?: run {
                            _statePriorityCounter2
                        }

                    }


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _statePriorityCounter2.value = ""
                }
            })

        return _statePriorityCounter2
    }

    override fun getCurrentCounterCLastPriorityNumber(): Flow<String?> {
        databaseReference.reference.child("counter3")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.children.forEach { childSnapshot ->
                        val pnumber = childSnapshot.child("pnumber").getValue(String::class.java)

                        pnumber?.let {
                            _statePrioriorityCounter3.value = it
                        } ?: run {
                            Log.d("TEST", "NULL MAN WALAAY VALUE")
                        }

                    }


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _statePrioriorityCounter3.value = ""
                }
            })

        return _statePrioriorityCounter3
    }

    override fun getCurrentCounterDLastPriorityNumber(): Flow<String?> {
        databaseReference.reference.child("counter4")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.children.forEach { childSnapshot ->
                        val pnumber = childSnapshot.child("pnumber").getValue(String::class.java)
                        pnumber?.let {
                            _statePriorityCounter4.value = it
                        } ?: run {
                            Log.d("TEST", "NULL MAN WALAAY VALUE")
                        }

                    }


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _statePriorityCounter4.value = ""
                }
            })

        return _statePriorityCounter4
    }

    override fun getCurrentTellerQueueLastPriorityNumber(): Flow<String?> {
        databaseReference.reference.child("tellering")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.children.forEach { childSnapshot ->
                        val pnumber = childSnapshot.child("pnumber").getValue(String::class.java)

                        pnumber?.let {
                            _statePriorityTeller.value = it
                        }

                    }


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _statePriorityTeller.value = ""
                }
            })

        return _statePriorityTeller
    }

    override fun getCurrentNowServingOfCounterA(): Flow<String?> {
        databaseReference.reference.child("queue").child("counter1")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val data = dataSnapshot.getValue(Long::class.java)

                    data?.let {
                        Log.d("TEST", " counter 1 $it")
                        _currentNowServingCounterA.value = it.toString()
                    }
//
//                    }

                    /**
                     * This method will be triggered in the event that this listener either failed at the server, or
                     * is removed as a result of the security and Firebase Database rules. For more information on
                     * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                     *
                     * @param error A description of the error that occurred
                     */


                    /**
                     * This method will be triggered in the event that this listener either failed at the server, or
                     * is removed as a result of the security and Firebase Database rules. For more information on
                     * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                     *
                     * @param error A description of the error that occurred
                     */

                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        return _currentNowServingCounterA
    }

    override fun getCurrentNowServingOfCounterB(): Flow<String?> {
        databaseReference.reference.child("queue").child("counter2")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val data = dataSnapshot.getValue(Long::class.java)

                    data?.let {
                        _currentNowServingCounterB.value = it.toString()
                    }

                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _currentNowServingCounterB.value = ""
                }


                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */

            })
        return _currentNowServingCounterB
    }

    override fun getCurrentNowServingOfCounterC(): Flow<String?> {
        databaseReference.reference.child("queue").child("counter3")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val data = dataSnapshot.getValue(Long::class.java)

                    data?.let {
                        _currentNowServingCounterC.value = it.toString()
                    }

                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _currentNowServingCounterC.value = ""
                }


                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */

            })
        return _currentNowServingCounterC
    }

    override fun getCurrentNowServingOfCounterD(): Flow<String?> {
        databaseReference.reference.child("queue").child("counter4")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val data = dataSnapshot.getValue(Long::class.java)

                    data?.let {
                        _currentNowServingCounterD.value = it.toString()
                    }
                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _currentNowServingCounterD.value = ""
                }


                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */

            })
        return _currentNowServingCounterD
    }

    override fun getCurrentNowServingOfCounterE(): Flow<String?> {
        databaseReference.reference.child("queue").child("tellering")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val data = dataSnapshot.getValue(Long::class.java)
                    Log.d("TEST", "$data")
                    data?.let {
                        _currentNowServingCounterE.value = it.toString()
                    }
                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    _currentNowServingCounterE.value = ""
                }


                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */

            })
        return _currentNowServingCounterE
    }


    override suspend fun checkCounter1ForPriorityNumber(priorityNumber: String) {
        var hasData: Boolean = false
        var userResponse: UserResponse? = null
        databaseReference.reference.child("counter1").orderByChild("pnumber")
            .equalTo(priorityNumber)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                /**
                 * This method will be called with a snapshot of the data at this location. It will also be called
                 * each time that data changes.
                 *
                 * @param snapshot The current data at the location
                 */
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eachChildren in snapshot.children) {
                        Log.d("TEST", "Value bay ${eachChildren.value}")
                        val pnumber = eachChildren.child("pnumber").getValue(String::class.java)
                        Log.d("TEST", "Priority number $pnumber")
                        val firstName = eachChildren.child("fname").getValue(String::class.java)
                        Log.d("TEST", "First name $firstName")
                        val lastName = eachChildren.child("lname").getValue(String::class.java)
                        val middleName =
                            eachChildren.child("mname").getValue(String::class.java)
                        val date = eachChildren.child("date").getValue(String::class.java)
                        val priorityNum =
                            eachChildren.child("pnumber").getValue(String::class.java)
                        val municipality = eachChildren.child("mun").getValue(String::class.java)
                        val barangay = eachChildren.child("brgy").getValue(String::class.java)
                        val residence = eachChildren.child("residence").getValue(String::class.java)
                        firstName?.let { first ->
                            lastName?.let { last ->
                                middleName?.let { middle ->
                                    date?.let { date ->

                                        priorityNum?.let { priorityNumber ->

                                            userResponseState.value =
                                                (UserResponse(
                                                    Name(first, last, middle),
                                                    date = date,
                                                    priorityNumber = priorityNumber,
                                                    municipality = municipality,
                                                    barangay = barangay,
                                                    residence = residence,

                                                    ))
                                        }
                                    }
                                }
                            }
                        }
                    }


                    /**
                     * This method will be triggered in the event that this listener either failed at the server, or
                     * is removed as a result of the security and Firebase Database rules. For more information on
                     * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                     *
                     * @param error A description of the error that occurred
                     */


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    Log.d("TEST", " Message ${error.message}")
                }


            })

    }

    override suspend fun checkCounter2orPriorityNumber(priorityNumber: String) {
        databaseReference.reference.child("counter2").orderByChild("pnumber")
            .equalTo(priorityNumber)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                /**
                 * This method will be called with a snapshot of the data at this location. It will also be called
                 * each time that data changes.
                 *
                 * @param snapshot The current data at the location
                 */
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eachChildren in snapshot.children) {
                        Log.d("TEST", "Value bay ${eachChildren.value}")
                        val pnumber = eachChildren.child("pnumber").getValue(String::class.java)
                        Log.d("TEST", "Priority number $pnumber")
                        val firstName = eachChildren.child("fname").getValue(String::class.java)
                        Log.d("TEST", "Priority number $firstName")
                        val lastName = eachChildren.child("lname").getValue(String::class.java)
                        val middleName =
                            eachChildren.child("mname").getValue(String::class.java)
                        val date = eachChildren.child("date").getValue(String::class.java)
                        val priorityNum =
                            eachChildren.child("pnumber").getValue(String::class.java)
                        val municipality = eachChildren.child("mun").getValue(String::class.java)
                        val barangay = eachChildren.child("brgy").getValue(String::class.java)
                        val residence = eachChildren.child("residence").getValue(String::class.java)
                        firstName?.let { first ->
                            lastName?.let { last ->
                                middleName?.let { middle ->
                                    date?.let { date ->

                                        priorityNum?.let { priorityNumber ->

                                            userResponseState.value =
                                                (UserResponse(
                                                    Name(first, last, middle),
                                                    date = date,
                                                    priorityNumber = priorityNumber,
                                                    municipality = municipality,
                                                    residence = residence,
                                                    barangay = barangay
                                                )
                                                        )
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */


                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    Log.d("TEST", " Message ${error.message}")
                }


            })
    }

    override suspend fun checkCounter3orPriorityNumber(priorityNumber: String) {
        databaseReference.reference.child("counter3").orderByChild("pnumber")
            .equalTo(priorityNumber)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                /**
                 * This method will be called with a snapshot of the data at this location. It will also be called
                 * each time that data changes.
                 *
                 * @param snapshot The current data at the location
                 */
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eachChildren in snapshot.children) {
                        Log.d("TEST", "Value bay ${eachChildren.value}")
                        val pnumber = eachChildren.child("pnumber").getValue(String::class.java)
                        Log.d("TEST", "Priority number $pnumber")
                        val firstName = eachChildren.child("fname").getValue(String::class.java)
                        Log.d("TEST", "Priority number $firstName")
                        val lastName = eachChildren.child("lname").getValue(String::class.java)
                        val middleName =
                            eachChildren.child("mname").getValue(String::class.java)
                        val date = eachChildren.child("date").getValue(String::class.java)
                        val priorityNum =
                            eachChildren.child("pnumber").getValue(String::class.java)
                        val municipality = eachChildren.child("mun").getValue(String::class.java)
                        val barangay = eachChildren.child("brgy").getValue(String::class.java)
                        val residence = eachChildren.child("residence").getValue(String::class.java)
                        firstName?.let { first ->
                            lastName?.let { last ->
                                middleName?.let { middle ->
                                    date?.let { date ->

                                        priorityNum?.let { priorityNumber ->

                                            userResponseState.value =
                                                (UserResponse(
                                                    Name(first, last, middle),
                                                    date = date,
                                                    priorityNumber = priorityNumber,
                                                    municipality = municipality,
                                                    barangay = barangay,
                                                    residence = residence


                                                ))
                                        }
                                    }
                                }
                            }
                        }
                    }


                    /**
                     * This method will be triggered in the event that this listener either failed at the server, or
                     * is removed as a result of the security and Firebase Database rules. For more information on
                     * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                     *
                     * @param error A description of the error that occurred
                     */


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    Log.d("TEST", " Message ${error.message}")
                }


            })
    }

    override suspend fun checkCounter4orPriorityNumber(priorityNumber: String) {
        databaseReference.reference.child("counter4").orderByChild("pnumber")
            .equalTo(priorityNumber)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                /**
                 * This method will be called with a snapshot of the data at this location. It will also be called
                 * each time that data changes.
                 *
                 * @param snapshot The current data at the location
                 */
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eachChildren in snapshot.children) {
                        Log.d("TEST", "Value bay ${eachChildren.value}")
                        val pnumber = eachChildren.child("pnumber").getValue(String::class.java)
                        Log.d("TEST", "Priority number $pnumber")
                        val firstName = eachChildren.child("fname").getValue(String::class.java)
                        Log.d("TEST", "Priority number $firstName")
                        val lastName = eachChildren.child("lname").getValue(String::class.java)
                        val middleName =
                            eachChildren.child("mname").getValue(String::class.java)
                        val date = eachChildren.child("date").getValue(String::class.java)
                        val priorityNum =
                            eachChildren.child("pnumber").getValue(String::class.java)
                        val municipality = eachChildren.child("mun").getValue(String::class.java)
                        val barangay = eachChildren.child("brgy").getValue(String::class.java)
                        val residence = eachChildren.child("residence").getValue(String::class.java)
                        firstName?.let { first ->
                            lastName?.let { last ->
                                middleName?.let { middle ->
                                    date?.let { date ->

                                        priorityNum?.let { priorityNumber ->

                                            userResponseState.value = UserResponse(
                                                Name(first, last, middle),
                                                date = date,
                                                priorityNumber = priorityNumber,
                                                municipality = municipality,
                                                residence = residence,
                                                barangay = barangay
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }


                    /**
                     * This method will be triggered in the event that this listener either failed at the server, or
                     * is removed as a result of the security and Firebase Database rules. For more information on
                     * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                     *
                     * @param error A description of the error that occurred
                     */


                }

                /**
                 * This method will be triggered in the event that this listener either failed at the server, or
                 * is removed as a result of the security and Firebase Database rules. For more information on
                 * securing your data, see: [ Security
 * Quickstart](https://firebase.google.com/docs/database/security/quickstart)
                 *
                 * @param error A description of the error that occurred
                 */
                override fun onCancelled(error: DatabaseError) {
                    Log.d("TEST", " Message ${error.message}")
                }


            })
    }
}













