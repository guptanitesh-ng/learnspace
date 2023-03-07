package com.manifest.concept.concurrency;

/**
 * Problem statement
 * 
 * A barber shop consists of a waiting room with n chairs, and a barber chair
 * for giving haircuts.
 * 
 * If there are no customers to be served, the barber goes to sleep.
 * 
 * If a customer enters the barbershop and all chairs are occupied, then the
 * customer leaves the shop.
 * 
 * If the barber is busy, but chairs are available, then the customer sits in
 * one of the free chairs. If the barber is asleep, the customer wakes up the
 * barber.
 * 
 * Write a program to coordinate the interaction between the barber and the
 * customers.
 * 
 * 
 * Tips to help solve the problem
 * 
 * First, identify the different state transitions for this problem. Let’s look
 * at them piecemeal: A customer enters the shop and if all N chairs are
 * occupied, he leaves. This hints at maintaining a count of the waiting
 * customers.
 * 
 * If any of the N chairs is free, the customer takes up the chair to wait for
 * his turn. Note this translates to using a semaphore on which threads that
 * have found a free chair wait on before being called in by the barber for a
 * haircut.
 * 
 * If a customer enters the shop and the barber is asleep it implies there are
 * no customers in the shop. The just-entered customer thread wakes up the
 * barber thread. This sounds like using a signaling construct to wake up the
 * barber thread.
 * 
 * 
 * Common pitfalls
 * 
 * A common pitfall here is for the program to enter a deadlock. The barber and
 * the newly-arrived customer check each other’s status at the same time so they
 * deadlock because at that moment:
 * 
 * The barber sees no one sitting in a chair and thinks the waiting room is
 * empty so goes to sleep The customer thinks the barber is busy so doesn’t try
 * to wake up the barber and just patiently waits for the barber Another pitfall
 * that developers may run into is starvation. This is because in some
 * solutions, there is no guarantee that customers are served in the order they
 * arrive, so they will continually wait for a resource that is given to other
 * processes.
 * 
 * You can avoid starvation by using a queue, where customers are added as they
 * arrive, so that barber can serve them on a first come first serve basis.
 * 
 * @author nitesh.gupta
 *
 */
public class BarberShopProblem {

}
